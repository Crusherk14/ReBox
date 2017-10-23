package servletpackage;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.GroupAuthResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VkMessageSender implements MessageSender{
    private static final String ACCESS_TOKEN = "8d4d81adbc91f363b217ccbcc622e3f8" +
            "b604b52b9b6686f3e53a1a3c0ffa03dbaf6ff05f6c03944c4ba45";
    private static final Integer APP_ID = 6228167;
    private static final String CLIENT_SECRET = "AEOnpJspcgfQr2Cdi8bw";
    private static final String REDIRECT_URI = "213.21.7.13:8080/messagesender/vk";
    private static final String OATH_URI = "https://oauth.vk.com/authorize?client_id="
            + APP_ID + "&display=popup&client_secret=" + CLIENT_SECRET + "&redirect_uri="
            + REDIRECT_URI + "&scope=messages&response_type=code&v=5.68";
    private static final Integer GROUP_ID = 155432811;
    HttpServletRequest request;
    HttpServletResponse response;

    TransportClient transportClient = HttpTransportClient.getInstance();
    VkApiClient vk = new VkApiClient(transportClient);
    HttpClient httpClient = new DefaultHttpClient();
    HttpGet post = new HttpGet(OATH_URI);
    HttpResponse responseParams;

    // TODO: use user_ids param: it'll let you send to up to 100 users
    public void SendMessage(Integer user, String message) throws ServletException, IOException {
        response.sendRedirect(OATH_URI);
        /*System.out.print(response.toString());
        post.abort();
        //String err = response.getFirstHeader("error").getValue();
        String code = response.getFirstHeader("code").getValue();
        try {
            GroupAuthResponse authResponse = vk.oauth()
                    .groupAuthorizationCodeFlow(APP_ID, CLIENT_SECRET, REDIRECT_URI, code)
                    .execute();
            GroupActor actor = new GroupActor(GROUP_ID, authResponse.getAccessTokens().get(GROUP_ID));
            vk.messages().send(actor).message(message).userId(user);
        } catch (Throwable e){
            e.printStackTrace();
        }*/
    }

    public VkMessageSender(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
    }
}
