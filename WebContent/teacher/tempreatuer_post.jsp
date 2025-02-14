<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/menu.jsp">
    <c:param name="title">体温投稿</c:param>
    <c:param name="content">
        <div class="tempoheader">体温</div>
        <form action="submitRecord.jsp" method="post" class="tempo-form">
            <div class="tempoform-group">
                <label for="start-date">期間</label>
                <div class="date-range">
                    <input type="date" id="start-date" name="start_date" required>
                    <span class="date-range-span">～</span>
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

<style>
    .tempoheader {
        font-size: 24px;
        font-weight: bold;
        text-align: center;
        margin-bottom: 20px;
    }

    .tempo-form {
        width: 100%;
        max-width: 600px;
        margin: 0 auto;
        padding: 20px;
        background-color: #f4f7fa;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }

    .tempoform-group {
        margin-bottom: 20px;
    }

    label {
        display: block;
        font-size: 16px;
        margin-bottom: 8px;
    }

    .date-range {
        display: flex;
        align-items: center;
        gap: 10px;
    }

    input[type="date"] {
        width: 48%;
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    .date-range-span {
        font-size: 18px;
        font-weight: bold;
    }

    .tempoform-buttons {
        display: flex;
        justify-content: space-between;
        gap: 10px;
    }

    .btn-back, .btn-submit {
        padding: 10px 20px;
        font-size: 16px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .btn-back {
        background-color: #f2f2f2;
        color: #333;
    }

    .btn-back:hover {
        background-color: #d1d1d1;
    }

    .btn-submit {
        background-color: #4e9f3d;
        color: white;
    }

    .btn-submit:hover {
        background-color: #3c7a2e;
    }

    @media (max-width: 768px) {
        .date-range {
            flex-direction: column;
        }

        .tempo-form {
            padding: 15px;
        }
    }
</style>
