package soaint.bpmapi.commons.exception.webClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BusinessException {

    public static String codeSizeIsEmpty;
    public static String valueSizeIsEmpty;
    public static String valueObjectNoFound;

    //When catch all exception
    public static String codeCatchAllException;

    //When catch any bad operations
    public static String codeBadOperationGeneric;
    public static String valueBadOperationGeneric;

    //When catch BadOperation in JBPM
    public static String codeBadResponseJbpm;
    public static String valueBadResponseJbpm;

    //when listOrg service failed
    public static String codeFailList;
    public static String valueFailList;

    //when email is null or invalidate
    public static String vEmailErrorException;
    public static String cEmailErrorException;

    //when service pagos/liquidacion is null
    public static String codePagosVacio;
    public static String valuePagosVacio;
    public static String codeLiquidacionVacia;
    public static String valueLiquidacionsVacia;

    //when addressees list is empty
    public static String codeAddressesListEmpty;
    public static String valueAddressesListEmpty;

    //when parametersList is incomplet
    public static String codeParametersListIncomplet;
    public static String valueParametersListIncomplet;

    //when parametersList is empty
    public static String codeParametersListEmpty;
    public static String valueParametersListEmpty;

    //when query service getPlantilla returns empty
    public static String codeServiceGetPlantillaReturnEmpty;
    public static String valueServiceGetPlantillaReturnEmpty;

    //When catch parameter empty
    public static String codeParametertIsEmpty;
    public static String valueParametertIsEmpty;

    //When catch Invalid Grant
    public static String codeInvalidGrant;
    public static String valueInvalidGrant;


    //set All Business Exceptions
    @Autowired
    private void setBusinessExceptions(
            @Value("${business.exception.codeSizeIsEmpty}") String cSizeIsEmpty,
            @Value("${business.exception.valueSizeIsEmpty}") String vSizeIsEmpty,
            @Value("${business.exception.valueObjectNoFound}") String vObjectNoFound,
            @Value("${business.exception.codeCatchAllException}") String cCatchAllException,
            @Value("${business.exception.codeBadOperationGeneric}") String cBadOperationGeneric,
            @Value("${business.exception.valueBadOperationGeneric}") String vBadOperationGeneric,
            @Value("${business.exception.codeParametertIsEmpty}") String cParametertIsEmpty,
            @Value("${business.exception.valueParametertIsEmpty}") String vParametertIsEmpty,
            @Value("${business.exception.apiJbpm.codeBadResponseJbpm}") String cBadResponseJbpm,
            @Value("${business.exception.apiJbpm.valueBadResponseJbpm}") String vBadResponseJbpm,
            @Value("${business.exception.codeFailListOrg}") String cFailList,
            @Value("${business.mesage.valueFailListOrg}") String vFailList,
            @Value("${business.exception.apiOrquestacion.correoNoExiste}") String cEmailError,
            @Value("${business.exception.apiOrquestacion.valueCorreoNoExiste}") String vEmailError,
            @Value("${bussiness.exception.codePagosVacios}") String cPagoVacio,
            @Value("${bussiness.exception.valuePagosVacios}") String vPagoVacio,
            @Value("${bussiness.exception.codeLiquidacionsVacia}") String cLiquidacionVacia,
            @Value("${bussiness.exception.valueLiquidacionsVacia}") String vLiquidacionVacia,
            @Value("${bussiness.exception.codeAddressesListEmpty}") String cAddressesListEmpty,
            @Value("${bussiness.exception.valueAddressesListEmpty}") String vAddressesListEmpty,
            @Value("${bussiness.exception.codeParametersListIncomplet}") String cParametersListIncomplet,
            @Value("${bussiness.exception.valueParametersListIncomplet}") String vParametersListIncomplet,
            @Value("${bussiness.exception.codeParametersListEmpty}") String cParametersListEmpty,
            @Value("${bussiness.exception.valueParametersListEmpty}") String vParametersListEmpty,
            @Value("${bussiness.exception.codeParametersListEmpty}") String cServiceGetPlantillaReturnEmpty,
            @Value("${bussiness.exception.valueParametersListEmpty}") String vServiceGetPlantillaReturnEmpty,
            @Value("${bussiness.exception.codeInvalidGrant}") String cInvalidGrant,
            @Value("${bussiness.exception.valueInvalidGrant}") String vInvalidGrant


    ) {
        codeSizeIsEmpty = cSizeIsEmpty;
        valueSizeIsEmpty = vSizeIsEmpty;
        codeCatchAllException = cCatchAllException;
        codeBadOperationGeneric = cBadOperationGeneric;
        valueBadOperationGeneric = vBadOperationGeneric;
        codeParametertIsEmpty = cParametertIsEmpty;
        valueParametertIsEmpty = vParametertIsEmpty;
        codeBadResponseJbpm = cBadResponseJbpm;
        valueBadResponseJbpm = vBadResponseJbpm;
        vEmailErrorException = vEmailError;
        cEmailErrorException = cEmailError;
        valueObjectNoFound = vObjectNoFound;
        codePagosVacio = cPagoVacio;
        valuePagosVacio = vPagoVacio;
        codeLiquidacionVacia = cLiquidacionVacia;
        valueLiquidacionsVacia = vLiquidacionVacia;
        codeAddressesListEmpty = cAddressesListEmpty;
        valueAddressesListEmpty = vAddressesListEmpty;
        codeParametersListIncomplet = cParametersListIncomplet;
        valueParametersListIncomplet = vParametersListIncomplet;
        codeParametersListEmpty = cParametersListEmpty;
        valueAddressesListEmpty = vParametersListEmpty;
        codeServiceGetPlantillaReturnEmpty = cServiceGetPlantillaReturnEmpty;
        valueServiceGetPlantillaReturnEmpty = vServiceGetPlantillaReturnEmpty;
        codeInvalidGrant = cInvalidGrant;
        valueInvalidGrant = vInvalidGrant;

    }

}
