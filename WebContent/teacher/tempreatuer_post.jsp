<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/menu.jsp">
    <c:param name="title">体温投稿</c:param>
    <c:param name="content">
        <div class="tempoheader">体温</div>
        <form action="submitRecord.jsp" method="post">
            <div class="tempoform-group">
                 <label for="start-date">期間</label>
                <div class="date-range">
                    <input type="date" id="start-date" name="start_date" required>
                    <span>～</span>
                    <input type="date" id="end-date" name="end_date" required>
                </div>
            </div>
            <div class="tempoform-buttons">
                <button type="button" class="btn-back" onclick="history.back()">戻る</button>
                <button type="submit" class="btn-submit">投稿</button>
            </div>
        </form>
    </c:param>
</c:import>
