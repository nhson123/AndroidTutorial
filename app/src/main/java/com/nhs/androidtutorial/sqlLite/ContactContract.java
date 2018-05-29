package com.nhs.androidtutorial.sqlLite;

/**
 * Created by Hoang Son Nguyen nhs@gmx.at on ${DATETIME}.
 */
public final class ContactContract {
    private ContactContract(){}

    public static class ContactEntry{
        //DB Schema
        public static final String TABLE_NAME = "contact_info";
        public static final String CONTRACT_ID = "contract_id";
        public static final String CONTRACT_NAME = "contract_name";
        public static final String CONTRACT_EMAIL = "contract_email";
    }
}
