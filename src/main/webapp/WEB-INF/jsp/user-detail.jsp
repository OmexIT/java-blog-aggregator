<%--
  Created by IntelliJ IDEA.
  User: omexic
  Date: 6/13/2015
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="../layout/taglib.jsp" %>

<h1><c:out value="${user.name}"/></h1>

<br/><br/>

<script type="text/javascript">
    $(document).ready(function () {
        $('#myTab a:first').tab('show'); // Select first tab
        $(".triggerRemove").click(function (e) {
            e.preventDefault();
            $("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
            $("#modalRemove").modal();
        });
    });
</script>

<ul class="nav nav-tabs" role="tablist" id="myTab">
    <c:forEach items="${user.blogs}" var="blog">
        <li role="presentation"><a href="#blog_${blog.id}" aria-controls="home" role="tab"
                                   data-toggle="tab">${blog.name}</a></li>
    </c:forEach>
</ul>

<div class="tab-content">
    <c:forEach items="${user.blogs}" var="blog">
        <div role="tabpanel" class="tab-pane" id="blog_${blog.id}">
            <h1>${blog.name}</h1>

            <p>
                <a href="<spring:url value="/blog/remove/${blog.id}.html"/>" class="btn btn-danger triggerRemove">Remove
                    Blog</a>
                    ${blog.url}
            </p>

            <table class="table table-bordered table-hover table-striped">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Link</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${blog.items}" var="item">
                    <tr>
                        <td> ${item.title}</td>
                        <td> ${item.link}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:forEach>
</div>


<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modalRemoveLabel">Remove blog</h4>
            </div>
            <div class="modal-body">
                Really remove?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <a href="" class="btn btn-danger removeBtn">Remove</a>
            </div>
        </div>
    </div>
</div>
