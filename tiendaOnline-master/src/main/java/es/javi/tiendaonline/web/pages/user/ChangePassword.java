package es.javi.tiendaonline.web.pages.user;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Cookies;

import es.javi.tiendaonline.model.userservice.IncorrectPasswordException;
import es.javi.tiendaonline.model.userservice.UserService;
import es.javi.tiendaonline.web.pages.Index;
import es.javi.tiendaonline.web.services.AuthenticationPolicy;
import es.javi.tiendaonline.web.services.AuthenticationPolicyType;
import es.javi.tiendaonline.web.util.CookiesManager;
import es.javi.tiendaonline.web.util.UserSession;
import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;

@AuthenticationPolicy(AuthenticationPolicyType.AUTHENTICATED_USERS)
public class ChangePassword {

    @Property
    private String oldPassword;

    @Property
    private String newPassword;

    @Property
    private String retypeNewPassword;

    @SessionState(create=false)
    private UserSession userSession;

    @Component
    private Form changePasswordForm;

    @Inject
    private Cookies cookies;

    @Inject
    private Messages messages;

    @Inject
    private UserService userService;

    void onValidateFromChangePasswordForm() throws InstanceNotFoundException {

        if (!changePasswordForm.isValid()) {
            return;
        }

        if (!newPassword.equals(retypeNewPassword)) {
            changePasswordForm
                    .recordError(messages.get("error-passwordsDontMatch"));
        } else {

            try {
                userService.changePassword(userSession.getUserProfileId(),
                        oldPassword, newPassword);
            } catch (IncorrectPasswordException e) {
                changePasswordForm.recordError(messages
                        .get("error-invalidPassword"));
            }

        }

    }

    Object onSuccess() {

        CookiesManager.removeCookies(cookies);
        return Index.class;

    }

}
