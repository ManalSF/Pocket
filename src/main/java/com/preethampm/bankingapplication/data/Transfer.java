package com.preethampm.bankingapplication.data;

public class Transfer {
    private Long transfertId;
    private String referenceCode;
    private String clientDonneurTele;
    private String clientBeneficiaireTele;
    private Double balanceDonneur;
    private Double soldeAgent;
    private Double montantOperation;

    public Transfer(Long transfertId, String referenceCode, String clientDonneurTele, String clientBeneficiaireTele, Double balanceDonneur, Double soldeAgent, Double montantOperation) {
        this.transfertId = transfertId;
        this.referenceCode = referenceCode;
        this.clientDonneurTele = clientDonneurTele;
        this.clientBeneficiaireTele = clientBeneficiaireTele;
        this.balanceDonneur = balanceDonneur;
        this.soldeAgent = soldeAgent;
        this.montantOperation = montantOperation;
    }

    public Long getTransfertId() {
        return transfertId;
    }

    public void setTransfertId(Long transfertId) {
        this.transfertId = transfertId;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getClientDonneurTele() {
        return clientDonneurTele;
    }

    public void setClientDonneurTele(String clientDonneurTele) {
        this.clientDonneurTele = clientDonneurTele;
    }

    public String getClientBeneficiaireTele() {
        return clientBeneficiaireTele;
    }

    public void setClientBeneficiaireTele(String clientBeneficiaireTele) {
        this.clientBeneficiaireTele = clientBeneficiaireTele;
    }

    public Double getBalanceDonneur() {
        return balanceDonneur;
    }

    public void setBalanceDonneur(Double balanceDonneur) {
        this.balanceDonneur = balanceDonneur;
    }

    public Double getSoldeAgent() {
        return soldeAgent;
    }

    public void setSoldeAgent(Double soldeAgent) {
        this.soldeAgent = soldeAgent;
    }

    public Double getMontantOperation() {
        return montantOperation;
    }

    public void setMontantOperation(Double montantOperation) {
        this.montantOperation = montantOperation;
    }
}
