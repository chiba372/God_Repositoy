<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/menu.jsp">
    <c:param name="title">連絡投稿</c:param>

    <c:param name="content">
        <div class="postcontainer">
            <div class="posttitle">連絡投稿</div>
            <form action="submitContact.jsp" method="post" class="contact-form">
                <div class="form-group">
                    <label for="subject">件名</label>
                    <input type="text" id="subject" name="subject" placeholder="件名を入力してください" required>
                </div>
                <div class="form-group">
                    <label for="postedDate">投稿日</label>
                    <input type="date" name="postedDate" required>
                </div>
                <div class="form-group">
                    <label for="content">内容</label>
                    <textarea id="content" name="content" placeholder="内容を入力してください" required></textarea>
                </div>
                <div class="form-group submit-button">
                    <input type="submit" value="送信" class="btn-submit">
                </div>
            </form>
        </div>
    </c:param>

</c:import>

<style>
    /* 以前のスタイルをそのまま使用 */
</style>
