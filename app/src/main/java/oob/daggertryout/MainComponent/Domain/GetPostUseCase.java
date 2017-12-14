package oob.daggertryout.MainComponent.Domain;

public class GetPostUseCase implements PostRepositoryInterface.OnPostCallbacks {

    private ViewInterface viewInterface;
    private PostRepositoryInterface postRepositoryInterface;

    public GetPostUseCase(ViewInterface viewInterface, PostRepositoryInterface postRepositoryInterface) {
        this.viewInterface = viewInterface;
        this.postRepositoryInterface = postRepositoryInterface;
    }

    public void getPost() {
        this.postRepositoryInterface.getPost(this);
    }

    @Override
    public void onSuccess(String text) {
        this.viewInterface.setText(text);
    }

    @Override
    public void onError(String error) {
        this.viewInterface.showErrorMessage(error);
    }
}
