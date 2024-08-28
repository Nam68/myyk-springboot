package yk.web.myyk.backend.dto.holder;

public class HtmlHolder extends BaseApiHolder {

    private String html;

    /**
     * <p>HTML코드를 설정한다.</p>
     *
     * @param html HTML코드
     */
    public void setHtml(String html) {
        this.html = html;
    }

    /**
     * <p>HTML코드를 반환한다.</p>
     *
     * @return HTML코드
     */
    public String getHtml() {
        return html;
    }
}
