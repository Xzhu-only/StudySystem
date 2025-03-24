<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>课程管理</title>
</head>

<style>
    /* 页面整体样式 */
    body, html {
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
      background-color: #fff;
      color: #333;
    }

    .container {
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
      padding: 20px;
      background-color: #f5f5f5;
    }

    .form-wrapper {
      width: 100%;
      max-width: 600px;
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    h1 {
      font-size: 1.5rem;
      margin-bottom: 20px;
      color: #333;
      text-align: center;
    }

    .error-message {
      color: #e74c3c;
      text-align: center;
      font-size: 14px;
      margin-bottom: 20px;
    }

    form {
      display: flex;
      flex-direction: column;
      gap: 15px;
    }

    label {
      font-size: 1rem;
      font-weight: bold;
      color: #333;
    }

    input, select, textarea {
      width: 100%;
      padding: 10px;
      border: 1px solid #ddd;
      border-radius: 5px;
      font-size: 1rem;
      color: #555;
      background-color: #fff;
    }

    input:focus, select:focus, textarea:focus {
      border-color: #096bcb;
      outline: none;
    }

    button {
      background-color: #0766c5;
      color: #fff;
      padding: 10px 15px;
      border: none;
      border-radius: 5px;
      font-size: 1rem;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    button:hover {
      background-color: #095ec8;
    }

    /* 响应式布局 */
    @media (max-width: 768px) {
      .form-wrapper {
        padding: 15px;
      }

      h1 {
        font-size: 1.2rem;
      }

      label {
        font-size: 0.9rem;
      }

      button {
        font-size: 0.9rem;
        padding: 8px;
      }
    }

    @media (max-width: 480px) {
      h1 {
        font-size: 1rem;
      }

      label {
        font-size: 0.8rem;
      }

      button {
        font-size: 0.8rem;
        padding: 6px;
      }
    }
  </style>
</head>
<body>
<div class="container">
  <div class="form-wrapper">
    <h1>添加课程</h1>

    <!-- 显示操作结果 -->
    <c:if test="${not empty message}">
      <p class="error-message">${message}</p>
    </c:if>

    <!-- 课程添加表单 -->
    <form action="/AddCourseServlet" method="post">
      <label for="Cname">课程名称：</label>
      <input type="text" id="Cname" name="Cname" placeholder="请输入课程名称" required>

      <label for="category">课程类别：</label>
      <select id="category" name="category" required>
        <option value="">请选择课程类别</option>
        <option value="专业选修">专业选修</option>
        <option value="专业必修">专业必修</option>
        <option value="学科大类必修">学科大类必修</option>
      </select>

      <label for="grade">课程难度：</label>
      <select id="grade" name="grade" required>
        <option value="">请选择课程难度</option>
        <option value="高级">高级</option>
        <option value="中级">中级</option>
        <option value="初级">初级</option>
      </select>

      <label for="introduce">课程简介：</label>
      <textarea id="introduce" name="introduce" rows="5" placeholder="请输入课程简介" required></textarea>

      <button type="submit">提交</button>
    </form>
  </div>
</div>
</body>
</html>
