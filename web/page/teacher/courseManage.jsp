<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="course-management">
  <header class="page-header">
    <h2>课程管理</h2>
  </header>

  <section>
    <div class="course-actions">
      <a href="<%= request.getContextPath() %>/page/teacher/addCourse.jsp">
        <button>创建课程</button>
      </a>
    </div>

    <table class="course-table">
      <thead>
      <tr>
        <th>课程ID</th>
        <th>课程名称</th>
        <th>课程类别</th>
        <th>课程难度</th>
        <th>课程简介</th>
      </tr>
      </thead>
      <tbody>
      <!-- 使用 JSTL 遍历课程列表 -->
      <c:forEach var="course" items="${courseList}">
        <tr>
          <td>${course.courseId}</td>
          <td>${course.courseName}</td>
          <td>${course.category}</td>
          <td>${course.grade}</td>
          <td>${course.introduce}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </section>
</div>


<style>
  /* 整体样式 */
  body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    background-color: #fff; /* 修改背景为白色 */
    color: #333;
  }

  .course-management {
    max-width: 1200px;
    margin: 20px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  }

  .page-header h2 {
    font-size: 1.5rem;
    margin-bottom: 20px;
    color: #333;
    text-align: center;
  }

  .course-actions {
    margin-bottom: 20px;
    text-align: center;
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

  .course-table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
  }

  .course-table th,
  .course-table td {
    padding: 10px;
    border: 1px solid #ddd;
    text-align: center;
  }

  .course-table th {
    background-color: #096bcb;
    color: #fff;
    font-size: 1rem;
  }

  .course-table td {
    color: #555;
  }

  .course-table tr:hover {
    background-color: #f5f5f5;
  }

  /* 响应式布局 */
  @media (max-width: 768px) {
    .course-management {
      padding: 10px;
      margin: 10px;
    }

    .course-table th, .course-table td {
      font-size: 0.9rem;
      padding: 8px;
    }
  }

  @media (max-width: 480px) {
    .course-table th, .course-table td {
      font-size: 0.8rem;
      padding: 5px;
    }

    button {
      font-size: 0.9rem;
      padding: 8px 10px;
    }
  }
</style>
