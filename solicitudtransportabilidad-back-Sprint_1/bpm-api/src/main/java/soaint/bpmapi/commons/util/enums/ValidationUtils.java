package soaint.bpmapi.commons.util.enums;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import soaint.bpmapi.commons.exception.webClient.BusinessException;
import soaint.bpmapi.commons.exception.webClient.WebClientException;
import soaint.bpmapi.commons.util.anotations.RequiredParameter;
import soaint.bpmapi.commons.util.anotations.RequiredPrimitiveParameter;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Component
public class ValidationUtils {


    public static void validateNullEmptyObject(Object obj) throws WebClientException {
        Field[] attr = obj.getClass().getDeclaredFields();
        discoverNullEmptyObject(attr, obj);
        validateNullEmptyObjectSuperClass(obj);
    }


    public static void validateNullEmptyString(String value) throws WebClientException {
        if (value == null || "".equals(value)) {
            throw new WebClientException(BusinessException.codeParametertIsEmpty, "Error : " + BusinessException.valueParametertIsEmpty);
        }
    }

    private static void validateNullEmptyObjectSuperClassImpl(Field[] fields, Object obj) throws WebClientException {
        discoverNullEmptyObject(fields, obj);
    }

    private static void validateNullEmptyObjectSuperClass(Object obj) throws WebClientException {
        validateNullEmptyObjectSuperClassImpl(obj.getClass().getSuperclass().getDeclaredFields(), obj);
    }

    private static void discoverNullEmptyObject(Field[] attr, Object obj) throws WebClientException {
        for (int i = 0; i < attr.length; i++) {
            final Field currentAttr = attr[i];
            currentAttr.setAccessible(true);

            if (currentAttr.isAnnotationPresent(RequiredParameter.class)
                    || currentAttr.isAnnotationPresent(RequiredPrimitiveParameter.class)) {
                try {
                    Object value = currentAttr.get(obj);
                    System.out.println(currentAttr.getName() + " - " + value);
                    if (value == null || "".equals(value.toString())) {
                        throw new WebClientException(BusinessException.codeParametertIsEmpty, "Error : Parametro [" + currentAttr.getName() + "] " + BusinessException.valueParametertIsEmpty);
                    }
                    if (!currentAttr.isAnnotationPresent(RequiredPrimitiveParameter.class)) {
                        discoverNullEmptyObject(value.getClass().getDeclaredFields(), runGetter(currentAttr, obj));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static Object runGetter(Field field, Object o) throws WebClientException {
        // MZ: Find the correct method
        for (Method method : o.getClass().getDeclaredMethods()) {
            if ((method.getName().startsWith("get"))
                    && (method.getName().length() == (field.getName().length() + 3))) {
                if (method.getName().toLowerCase().endsWith(field.getName().toLowerCase())) {
                    // MZ: Method found, run it
                    try {
                        return method.invoke(o, null);
                    } catch (IllegalAccessException e) {
                        System.out.println("Could not determine method: " + method.getName());
                        throw new WebClientException(BusinessException.codeCatchAllException, "Could not determine method: " + method.getName());
                    } catch (InvocationTargetException e) {
                        System.out.println("Could not determine method: " + method.getName());
                        throw new WebClientException(BusinessException.codeCatchAllException, "Could not determine method: " + method.getName());
                    }

                }
            }
        }
        return o;
    }

    public static WebClientException catchServerClientException(HttpStatusCodeException e) {
        BaseResponseAdapter rs = null;
        try {
            rs = new Gson().fromJson(e.getResponseBodyAsString(), BaseResponseAdapter.class);
        } catch (JsonSyntaxException ex) {
        }
        String buildStackTrace = "Api Client [" + Thread.currentThread().getStackTrace()[2].getFileName().replaceAll(".java", "") + "] | Metodo Client [" + Thread.currentThread().getStackTrace()[2].getMethodName() + "] | ";
        String valueException = "";
        String messageException = "";
        if (rs == null) {
            valueException = String.valueOf(e.getStatusCode().value());
            messageException = e.getStatusText();
        } else {
            valueException = String.valueOf(rs.getStatus().value());
            messageException = rs.getMessage();
        }
        return new WebClientException(valueException, buildStackTrace + messageException);
    }

    public static void catchSQlException(Exception e) {
        String buildStackTrace = "Repository [" + Thread.currentThread().getStackTrace()[2].getFileName().replaceAll(".java", "") + "] | Query [" + Thread.currentThread().getStackTrace()[2].getMethodName() + "] | ";
    }

    public static void printLogErrorCatchException(Exception e) {
        String buildStackTrace = "Repository [" + Thread.currentThread().getStackTrace()[2].getFileName().replaceAll(".java", "") + "] | Query [" + Thread.currentThread().getStackTrace()[2].getMethodName() + "] | ";
    }

    public static String getTraceStringTraceException(Exception e) {
        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));
        return errors.toString();
    }

}
