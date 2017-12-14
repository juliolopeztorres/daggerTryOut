package oob.daggertryout.MainComponent.Domain;

public interface PostRepositoryInterface {
    void getPost(OnPostCallbacks listener);

    interface OnPostCallbacks {
        void onSuccess(String text);

        void onError(String error);
    }
}
