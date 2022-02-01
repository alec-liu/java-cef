#include "CefSelectClientCertificateCallback_N.h"
#include "include/cef_request_handler.h"
#include "jni_scoped_helpers.h"
#include "jni_util.h"

namespace {

CefRefPtr<CefSelectClientCertificateCallback> GetSelf(jlong self) {
  return reinterpret_cast<CefSelectClientCertificateCallback*>(self);
}

void ClearSelf(JNIEnv* env, jobject obj) {
  // Clear the reference added in RequestHandler::GetAuthCredentials.
  SetCefForJNIObject<CefSelectClientCertificateCallback>(
      env, obj, nullptr, "CefSelectClientCertificateCallback");
}

}  // namespace

JNIEXPORT void JNICALL
Java_org_cef_callback_CefSelectClientCertificateCallback_1N_N_1Select(
    JNIEnv* env,
    jobject obj,
    jlong self,
    jobject certifselected) {
  CefRefPtr<CefSelectClientCertificateCallback> callback = GetSelf(self);
  if (!callback)
    return;
  callback->Select(GetJNIX509Certificate(
      env, certifselected));  // CefRefPtr< CefX509Certificate > cert
  ClearSelf(env, obj);
}

/*
 * Class:     org_cef_callback_CefSelectClientCertificateCallback_N
 * Method:    N_Cancel
 * Signature: (J)V
 */
JNIEXPORT void JNICALL
Java_org_cef_callback_CefSelectClientCertificateCallback_1N_N_1Cancel(
    JNIEnv* env,
    jobject obj,
    jlong self) {
  CefRefPtr<CefSelectClientCertificateCallback> callback = GetSelf(self);
  if (!callback)
    return;
  ClearSelf(env, obj);
}
