<head>
	<title>用户注册</title>
</head>
<body>
	<div id="formsContent">
		<form:form id="form" method="post" modelAttribute="registrationDTO">
			<div class="header">
		  		<h2>Form</h2>
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
		  		<legend>注册</legend>
		  		<form:label path="email">电子邮箱</form:label>
		  		<form:input path="email" /><form:errors path="email" cssClass="error" /><br />
		  		<form:label path="password">密码</form:label>
		  		<form:password path="password" /><form:errors path="password" cssClass="error" /><br />
		  		<form:label path="rePassword">确认密码</form:label>
		  		<form:password path="rePassword" /><form:errors path="rePassword" cssClass="error" /><br />
		  		<form:label path="nickname">昵称</form:label>
		  		<form:input path="nickname" /><form:errors path="nickname" cssClass="error" />		  				  			
		  	</fieldset>
			<p><button type="submit">Submit</button></p>
		</form:form>
	</div>
</body>