package UpGrad.aadhar;

public class AadharIdentifier {

    private int aadharNumber;
    private String fingerPrints;
    private String eyePrints;

    /**
     * @return the aadharNumber
     */
    public int getAadharNumber() {
        return aadharNumber;
    }

    /**
     * @param aadharNumber
     *            the aadharNumber to set
     */
    public void setAadharNumber(int aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    /**
     * @return the fingerPrints
     */
    public String getFingerPrints() {
        return fingerPrints;
    }

    /**
     * @param fingerPrints
     *            the fingerPrints to set
     */
    public void setFingerPrints(String fingerPrints) {
        this.fingerPrints = fingerPrints;
    }

    /**
     * @return the eyePrints
     */
    public String getEyePrints() {
        return eyePrints;
    }

    /**
     * @param eyePrints
     *            the eyePrints to set
     */
    public void setEyePrints(String eyePrints) {
        this.eyePrints = eyePrints;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((eyePrints == null) ? 0 : eyePrints.hashCode());
        result = prime * result + ((fingerPrints == null) ? 0 : fingerPrints.hashCode());
        result = prime * result + aadharNumber;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AadharIdentifier other = (AadharIdentifier) obj;
        if (this.eyePrints == null) {
            if (other.eyePrints != null)
                return false;
        } else if (!this.eyePrints.equals(other.eyePrints)) {
            return false;
        }
        if (this.fingerPrints == null) {
            if (other.fingerPrints != null)
                return false;
        } else if (!this.fingerPrints.equals(other.fingerPrints)) {
            return false;
        }
        if (this.aadharNumber != other.aadharNumber) {
            return false;
        }
        return true;
    }

}
