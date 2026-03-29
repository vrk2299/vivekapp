package com.vivek.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TaskServlet extends HttpServlet {

    private TaskService service = new TaskService();

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");

        String delete = req.getParameter("delete");
        String done = req.getParameter("done");

        if (delete != null) {
            service.deleteTask(Integer.parseInt(delete));
        }

        if (done != null) {
            service.markDone(Integer.parseInt(done));
        }

        PrintWriter out = res.getWriter();

        out.println("<html><head><meta charset='UTF-8'>");
        out.println("<style>");
        out.println("body{font-family:Arial;background:linear-gradient(135deg,#1e3c72,#2a5298);color:white;text-align:center;}");
        out.println(".container{margin-top:60px;}");
        out.println(".task{background:white;color:black;margin:10px auto;padding:12px;width:300px;border-radius:10px;display:flex;justify-content:space-between;align-items:center;}");
        out.println(".done{text-decoration:line-through;color:gray;}");
        out.println("a{margin-left:10px;text-decoration:none;font-size:18px;}");
        out.println("input{padding:10px;border-radius:6px;border:none;width:200px;}");
        out.println("button{padding:10px;border:none;border-radius:6px;background:#2a5298;color:white;}");
        out.println("</style></head><body>");

        out.println("<div class='container'>");
        out.println("<h1>Task Manager</h1>");

        int i = 0;
        for (TaskService.Task t : service.getTasks()) {
            out.println("<div class='task'>");

            String cls = t.done ? "done" : "";
            out.println("<span class='" + cls + "'>" + t.name + "</span>");

            out.println("<div>");
            out.println("<a href='?done=" + i + "'>✔</a>");
            out.println("<a href='?delete=" + i + "'>❌</a>");
            out.println("</div>");

            out.println("</div>");
            i++;
        }

        out.println("<form method='post'>");
        out.println("<input name='task' placeholder='Enter task' required/>");
        out.println("<br><br><button>Add Task</button>");
        out.println("</form>");

        out.println("<br><a href='index.jsp' style='color:white;'>Back</a>");
        out.println("</div></body></html>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String task = req.getParameter("task");
        service.addTask(task);

        res.sendRedirect("tasks");
    }
}
