package httpClient;

/**
 *
 * @author Yazan Habash
 */
public interface DownloadUpload {

    public static final String contentStr = "application/x-www-form-urlencoded";

    public void downloadPHP(String url);

    public void downloadServlet(String url);
}
