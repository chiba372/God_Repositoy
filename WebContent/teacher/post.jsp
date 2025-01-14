<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/menu.jsp">

	<c:param name="title">連絡投稿</c:param>


<c:param name="content">
    <div class="postcontainer">
        <div class="posttitle">連絡投稿</div>
        <form action="submitContact.jsp" method="post">
            <div class="postform-group">
                <label for="subject">件名</label>
                <input type="text" id="subject" name="subject" required>
            </div>
            <div class="postform-group">
                <label>期間</label>
                <div class="period">
                    <input type="date" name="startDate" required>
                    <input type="date" name="endDate" required>
                </div>
            </div>
            <div class="postform-group">
                <label for="content">内容</label>
                <textarea id="content" name="content" required></textarea>
            </div>
            <div class="postsubmit-btn">
                <input type="submit" value="送信">
            </div>
        </form>
    </div>

</c:param>

</c:import>