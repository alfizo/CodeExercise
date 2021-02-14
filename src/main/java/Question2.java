import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Question2 {

    public static void main(String args[]) throws IOException {

        Address[] add = readAddressFile();

        System.out.println("Run____________________________Question 2.a and 2.b___________________________________________________");
        //Question 2.a and 2.b

          PrintAllAddress();

        System.out.println("Run____________________________Question 2.c___________________________________________________________");
        //Question 2.c
        for (Address addr : add) {
             printAddressType(addr,"Physical Address");
            }

        System.out.println("_______________________________Question 2.d,e_________________________________________________________");
        //Question 2.e
        for (Address addr : add) {
            AddressResponse addrValid = isValiAddress(addr);

            if (addrValid.valid) {
                String address = prettyPrintAddress(addr);
                System.out.println(address);
            } else {

                System.out.println("Error Address record " + addr.id + " " + addrValid.message);
            }
        }

    }

    //Question 2.a
    public static String prettyPrintAddress(Address address) {
        String addformat = (address.addressLineDetail == null ? "" : "" + address.addressLineDetail.line1) +
                (address.addressLineDetail == null ? "" : " " + address.addressLineDetail.line2 + " ") +
                (address.getCityOrTown() == null ? "" : "" + address.getCityOrTown()) +
                (address.provinceOrState == null ? "" : "-" + address.provinceOrState.getName()) +
                (address.postalCode == null ? "" : " - " + address.postalCode + " ") +
                (address.country.name == null ? "" : " - " + address.country.name);
        return addformat;
    }

    //Question 2.b
    public static void PrintAllAddress() throws IOException {
        Address[] add = readAddressFile();

        for (Address addr : add) {
            System.out.println(prettyPrintAddress(addr));
        }
    }

    //Question 2.c
    public static void printAddressType(Address addressObj, String addressType) {
        String addrFormatType = "";
        if (addressObj.type.getName().equals(addressType)) {
            addrFormatType = (addressObj.addressLineDetail == null ? "" : "" + addressObj.addressLineDetail.line1) +
                    (addressObj.addressLineDetail == null ? "" : " " + addressObj.addressLineDetail.line2 + " ") +
                    (addressObj.getCityOrTown() == null ? "" : "" + addressObj.getCityOrTown()) +
                    (addressObj.provinceOrState == null ? "" : "-" + addressObj.provinceOrState.getName()) +
                    (addressObj.postalCode == null ? "" : " - " + addressObj.postalCode + " ") +
                    (addressObj.country.name == null ? "" : " - " + addressObj.country.name);
            System.out.println(addrFormatType);
        }
    }

    //Question (2d, i, ii)
    public static AddressResponse isValiAddress(Address addrObj) {
        AddressResponse addrRes = new AddressResponse();
        addrRes.valid= true;
        //if postalcode is a number.
        if (!isNumber(addrObj.postalCode)) {
            addrRes.message = "Invalid postal code provided, Postal code must be a number";
            addrRes.valid = false;
            return addrRes;
        }
        //validate that country is not null/empty
        if (addrObj.country.name == null || addrObj.country.name == "") {
            addrRes.message = "No country provided";
            addrRes.valid = false;
            return addrRes;
        }
        //if address line object is empty
        if (addrObj.addressLineDetail == null) {
            addrRes.message = "Invalid Address, No address detail provided";
            addrRes.valid = false;
            return addrRes;
        }
        //if both address line1 && line2 is empty
        if(Strings.isNullOrEmpty(addrObj.addressLineDetail.line1)&&(Strings.isNullOrEmpty(addrObj.addressLineDetail.line1))){
            addrRes.message = "Invalid Address, No address detail provided";
            addrRes.valid = false;
            return addrRes;
        }
        return addrRes;
    }

     //method validfates numbers
    public static boolean isNumber(String value) {
        return value.chars().allMatch(Character::isDigit);
    }

     //method reads json file and maps it to a class object
    public static Address[] readAddressFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        String content = new String(Files.readAllBytes(Paths.get("src\\main\\java\\addresses.json")));

        Address[] address = objectMapper.readValue(content, Address[].class);
        return address;
    }
}
