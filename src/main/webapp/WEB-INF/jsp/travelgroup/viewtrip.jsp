<head>
	<title>查看拼团</title>
</head>
<body>
	<form:form id="form" method="post" modelAttribute="travelGroupRemarkDTO" action="newremark">
		<div class="header">
	  		<c:if test="${not empty message}">
				<div id="message" class="success"><s:message code="${message}"/></div>	
	  		</c:if>
	  		<s:bind path="*">
	  			<c:if test="${status.error}">
			  		<div id="message" class="error">输入信息有误</div>
	  			</c:if>
	  		</s:bind>
		</div>
		<div id="viewContent">
		  	<table>
	  			<tr><td>出发景点</td><td><c:out value="${travelGroup.fromResort }"/></tr>
	  			<tr><td>出发城市</td><td><c:out value="${travelGroup.fromCity }"/></tr>
	  			<tr><td>出发地址</td><td><c:out value="${travelGroup.fromAddress }"/></tr>
	  			<tr><td>目的地城市</td><td><c:out value="${travelGroup.arrivalCity }"/></tr>
	  			<tr><td>目的地景点</td><td><c:out value="${travelGroup.arrivalResort }"/></tr>
	  			<tr><td>出发日期</td><td><c:out value="${travelGroup.fromDate }"/></tr>
	  			<tr><td>自助游类型</td><td><c:out value="${travelGroup.type }"/></tr>
	  			<tr><td>预计天数</td><td><c:out value="${travelGroup.days }"/></tr>
	  			<tr><td>最低参团人数</td><td><c:out value="${travelGroup.count }"/></tr>
	  			<tr><td>预计花费</td><td><c:out value="${travelGroup.budget }"/></tr>
	  			<tr><td>拼团主题</td><td><c:out value="${travelGroup.topic }"/></tr>
	  			<tr><td>备注</td><td><c:out value="${travelGroup.note }"/></tr>	
	  			<c:forEach items="${travelGroup.scheduleNotes }" var="scheduleNote">
	  				<tr><td>天数&nbsp;&nbsp;${scheduleNote.dayNumber}</td><td><c:out value="${scheduleNote.note}"/></tr>
	  			</c:forEach> 
	  			<tr><td colspan="2">评论</td></tr> 
	  			<c:forEach items="${travelGroup.travelGroupRemarks }" var="travelGroupRemark">
	  				<tr>
	  					<td><c:out value="${travelGroupRemark.nickname }"/>在 &nbsp;<fmt:formatDate value="${travelGroupRemark.date }" pattern="yyyy/MM/dd hh:mm:ss"/>说：</td>
	  					<td><c:out value="${travelGroupRemark.remark }"/>
	  				</tr>
	  			</c:forEach> 
	  			<tr><td colspan="2">进入人员</td></tr> 
	  			<c:forEach items="${travelGroup.travelGroupAccounts }" var="travelGroupAccount">
	  				<tr>
	  					<td colspan="2"><c:out value="${travelGroupAccount.nickname }"/>在 &nbsp;<fmt:formatDate value="${travelGroupAccount.date }" pattern="yyyy/MM/dd hh:mm:ss"/>加入</td>
	  				</tr>
	  			</c:forEach> 		  						
	  		</table>
	  		
	  		<s:url value="jointrip" var="jointripURL">
	  			<s:param name="id" value="${travelGroup.travelGroupId }"/>
	  		</s:url>
	  		<a href="${jointripURL }">参团</a>	  				  				  				  				  		
		</div>
	  	<fieldset>
	  		<legend>添加评论</legend>
	  		<form:input path="remark" /><br />
	  		<form:hidden path="travelGroupId"/>
		</fieldset>
		<p><button type="submit">Submit</button></p>
	</form:form>
</body>

