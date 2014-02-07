<head>
	<title>新建旅行方式</title>
</head>
<body>
	<div id="formsContent">
		<h2>新建旅行方式</h2>
		<form:form id="form" method="post" modelAttribute="travelTypeDTO">
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
		  	<fieldset>
		  		<legend>旅行方式</legend>
		  		<form:label path="typeName">类型</form:label>
		  		<form:input path="typeName" /><form:errors path="typeName" cssClass="error" /><br />
		  		<form:label path="sortOrder">排序</form:label>
		  		<form:input path="sortOrder" /><form:errors path="sortOrder" cssClass="error" /><br />		  			
		  	</fieldset>
			<p><button type="submit">Submit</button></p>
		</form:form>
	</div>
</body>

