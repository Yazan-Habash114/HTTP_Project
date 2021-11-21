package httpClient;

/**
 *
 * @author Yazan Habash
 */
public interface DownloadUpload {

    public static final String CONTENT_STR = "application/x-www-form-urlencoded";

    public void downloadPHP(String url);

    public void downloadServlet(String url);
}
