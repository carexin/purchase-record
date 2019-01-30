package org.liyd.app.web.rest.error;

public class ContactsAlreadyUsedException extends RecordException {
  public ContactsAlreadyUsedException() {
    super(ErrorConstants.CONTACTS_ALREADY_USED_TYPE, 500);
  }
}
