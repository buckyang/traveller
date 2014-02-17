<head>
	<title>用户登陆</title>
</head>
<body>
	<div id="formsContent">
		<form:form id="form" method="post" modelAttribute="loginDTO">
			<div class="header">
		  		<c:if test="${not empty message}">
					<div id="message" class="success"><s:message code="${message}"/></div>	
		  		</c:if>
				<form:errors cssClass="error" />
			</div>
		  	<fieldset>
		  		<legend>登陆</legend>
		  		<form:label path="email">电子邮箱</form:label>
		  		<form:input path="email" /><form:errors path="email" cssClass="error" /><br />
		  		<form:label path="password">密码</form:label>
		  		<form:password path="password" /><form:errors path="password" cssClass="error" />		  				  			
		  	</fieldset>
			<p><button type="submit">Submit</button></p>
		</form:form>
	</div>
</body>