#include "CefX509Certificate_N.h"

#include "jni_util.h"


namespace {

CefRefPtr<CefX509Certificate> GetSelf(jlong self) {
  return reinterpret_cast<CefX509Certificate*>(self);
}

void ClearSelf(JNIEnv* env, jobject obj) {

  SetCefForJNIObject<CefX509Certificate>(env, obj, NULL, "CefX509Certificate");
}

}  // namespac

JNIEXPORT void JNICALL Java_org_cef_security_CefX509Certificate_1N_N_1Release(JNIEnv* env,
                                                       jobject obj,
                                                       jlong self)
  {
	    CefRefPtr<CefX509Certificate> medium = GetSelf(self);
  if (!medium)
    return;
    ClearSelf(env,obj);
  }
