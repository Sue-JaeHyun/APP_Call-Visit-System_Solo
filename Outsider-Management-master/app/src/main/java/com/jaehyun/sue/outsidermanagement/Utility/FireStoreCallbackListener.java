package com.jaehyun.sue.outsidermanagement.Utility;

public interface FireStoreCallbackListener
{
    void doNext(boolean isSuccesful, Object obj);
    void occurError(int errorCode);
}
