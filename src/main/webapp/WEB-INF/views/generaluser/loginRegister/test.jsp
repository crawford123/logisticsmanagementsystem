<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 3/14/2018
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="signin-with-email">
    <desktop-input class="email ng-isolate-scope" field="loginForm.email" label="'login.email'" server-error="$ctrl.serverError" show-error-on-general-error="true"><md-input-container class="tooltip-holder ng-isolate-scope md-input-has-value" ng-class="{'has-error': !!$ctrl.getError()}" wix-tooltip="Looks like that didn’t work. Try again." is-open="$ctrl.showTooltip" max-width="225px" append-to-body="true" tooltip-trigger="false" placement="left" placement-force="true" style="">
        <label class="label ng-binding" for="input_0"> Email </label>
        <input autofocus="" default-email="" name="email" ng-attr-wix-mail-validator="{{!$ctrl.novalidateEmail()}}" ng-model="$ctrl.email" required="" type="email" class="ng-scope md-input ng-valid-email ng-touched ng-not-empty ng-dirty ng-valid-wix-mail-validator ng-valid ng-valid-required" id="input_0" wix-mail-validator="true" style="">
        <div class="focus-line"></div>
        <i class="login-svg-font-icons-error error"></i>
    </md-input-container></desktop-input>
    <desktop-input class="password ng-isolate-scope" field="loginForm.password" label="'login.password'" server-error="$ctrl.serverError"><md-input-container class="tooltip-holder ng-isolate-scope has-error md-input-invalid" ng-class="{'has-error': !!$ctrl.getError()}" wix-tooltip="This field is required." is-open="$ctrl.showTooltip" max-width="225px" append-to-body="true" tooltip-trigger="false" placement="left" placement-force="true" style="">
        <label class="label ng-binding" for="input_1"> Password </label>
        <input name="password" ng-minlength="4" ng-model="$ctrl.password" required="" type="password" class="ng-pristine ng-scope md-input ng-empty ng-invalid ng-invalid-required ng-valid-minlength ng-touched" id="input_1" style="">
        <div class="focus-line"></div>
        <i class="login-svg-font-icons-error error"></i>
    </md-input-container></desktop-input>
    <div class="remember-me-and-forgot-password">
        <label class="remember-me-section">
            <div class="remember-me-text ng-binding">Remember Me</div>
            <wix-checkbox><label allow-propagation-from="input" class="ng-scope">
                <input type="checkbox" class="remember-me ng-pristine ng-untouched ng-valid ng-not-empty" ng-model="$ctrl.rememberMe">
                <span class="wix-checkbox-inner"></span>
            </label></wix-checkbox>
        </label>
        <!-- ngIf: $ctrl.isAccountRecoveryFlowActivated() --><a class="forgot-password-link ng-binding ng-scope" ng-href="/account-recovery?sessionId=976b7c2c-fee1-ffd1-123f-c35861bd4d62" ng-if="$ctrl.isAccountRecoveryFlowActivated()" target="_self" href="/account-recovery?sessionId=976b7c2c-fee1-ffd1-123f-c35861bd4d62">Forgot Password?</a><!-- end ngIf: $ctrl.isAccountRecoveryFlowActivated() -->
        <!-- ngIf: !$ctrl.isAccountRecoveryFlowActivated() -->
    </div>
    <div class="recaptcha-widget" id="recaptcha-widget"></div>
    <div class="login-button">
        <div class="button-spinner">
            <button class="login-btn wix-button ng-binding" name="submit" ng-class="{'is-button-outline' : loginForm.$pristine}" ng-click="loginForm.$valid ? $ctrl.doLogin() : $ctrl.onSubmitInvalid()" ng-show="!$ctrl.loading" type="submit" style="">Log In</button>
            <div class="spinner-container ng-hide" ng-show="$ctrl.loading">
                <spinner class="ng-isolate-scope"><svg class="spinner" width="29" height="29" viewBox="0 0 66 66" "="">
                    <circle class="path" fill="none" stroke-width="6" stroke-linecap="round" cx="33" cy="33" r="30"></circle>
                    </svg></spinner>
            </div>
        </div>
    </div>
</div>

</body>
</html>
