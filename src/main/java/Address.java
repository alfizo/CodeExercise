import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.ANY,
        creatorVisibility = JsonAutoDetect.Visibility.NONE
)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    public String id;

    public type type;

    public AddressLineDetail addressLineDetail;

    public type provinceOrState;

    public String cityOrTown;

    public type country;

    public String postalCode;

    public String lastUpdated;

    public String suburbOrDistrict;

    public String getID() { return id; }
    public void setID(String value) { this.id = value; }

    public AddressLineDetail getAddressLineDetail() { return addressLineDetail; }
    public void setAddressLineDetail(AddressLineDetail value) { this.addressLineDetail = value; }

    public String getCityOrTown() { return cityOrTown; }
    public void setCityOrTown(String value) { this.cityOrTown = value; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String value) { this.postalCode = value; }

    public String getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(String value) { this.lastUpdated = value; }

    public String getSuburbOrDistrict() { return suburbOrDistrict; }
    public void setSuburbOrDistrict(String value) { this.suburbOrDistrict = value; }
}

class type {
    public String code;
    public String name;

    public String getCode() { return code; }
    public void setCode(String value) { this.code = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
}

class AddressResponse {
    public boolean valid = true;
    public String message;

    public boolean getvalid() { return valid; }
    public void setvalid(boolean value) { this.valid = value; }

    public String getmessage() { return message; }
    public void setmessage(String value) { this.message = value; }
}

class AddressLineDetail {
    public String line1;
    public String line2;

    public String getLine1() { return line1; }
    public void setLine1(String value) { this.line1 = value; }

    public String getLine2() { return line2; }
    public void setLine2(String value) { this.line2 = value; }
}




