package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        if(balance < 5000){
            throw new RuntimeException("Insufficient Balance");
        }
        this.tradeLicenseId = tradeLicenseId;
    }


    public void validateLicenseId() throws Exception {
        // Check if the license ID is already valid
        boolean isValid = true;
        for (int i = 0; i < tradeLicenseId.length() - 1; i++) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i + 1)) {
                isValid = false;
                break;
            }
        }
        if (!isValid) {
            // Try rearranging the characters to create a valid license ID
            char[] chars = tradeLicenseId.toCharArray();
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] == chars[i + 1]) {
                    for (int j = 0; j < chars.length; j++) {
                        if (chars[j] != chars[i] && (i == 0 || chars[j] != chars[i - 1])) {
                            // Swap the characters at positions i and j
                            char temp = chars[i];
                            chars[i] = chars[j];
                            chars[j] = temp;

                            // Check if the rearranged license ID is valid
                            isValid = true;
                            for (int k = 0; k < chars.length - 1; k++) {
                                if (chars[k] == chars[k + 1]) {
                                    isValid = false;
                                    break;
                                }
                            }

                            if (isValid) {
                                tradeLicenseId = new String(chars);
                                return;
                            }
                        }
                    }

                    // If no valid rearrangement is possible, throw an exception
                    throw new RuntimeException("Valid License can not be generated");
                }
            }
        }
    }

    private void rearrangeLicenseIdChars(char[] chars, int index) {
        char temp = chars[index];
        chars[index] = chars[index - 1];
        chars[index - 1] = temp;
    }

}
