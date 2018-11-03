package com.example.mvc.filter;

import com.example.mvc.model.Message;
import com.example.mvc.model.Role;
import com.example.mvc.model.User;
import com.google.common.collect.Lists;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "AuthorityFilter", servletNames = {"userServlet"})
public class AuthorityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req =(HttpServletRequest) request;
        HttpSession session = req.getSession();
        List<Role> roles = createRoles();

        if (isLogged(session)) {
            User user = (User) session.getAttribute("user");
            if (roles.contains(user.getRole())) {
                chain.doFilter(request, response);
            } else {
                noPermission(request, response);
            }
        } else {
            noPermission(request, response);
        }
    }

    private void noPermission(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        String value = "Nie masz odpowiednich uprawnień!";
        request.setAttribute("message", new Message(value, Message.Type.ERROR));
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private List<Role> createRoles() {
        List<Role> roles = Lists.newArrayList();
        roles.add(Role.ROLE_ADMIN);
        return roles;
    }

    private boolean isLogged(HttpSession session) {
        Object user = session.getAttribute("user");
        return user != null;
    }

    @Override
    public void destroy() {

    }
}
