<head>
	<title>密码更新</title>
</head>
<body>
	<div id="formsContent">
		<h2>密码更新</h2>
		<form:form id="form" method="post" modelAttribute="updatePasswordDTO">
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
		  		<legend>密码</legend>
		  		<form:label path="oldPass">旧密码</form:label>
		  		<form:password path="oldPass" /><form:errors path="oldPass" cssClass="error" /><br />
		  		<form:label path="pass">新密码</form:label>
		  		<form:password path="pass" /><form:errors path="pass" cssClass="error" /><br />		
		  		<form:label path="rePass">重复密码</form:label>
		  		<form:password path="rePass" /><form:errors path="rePass" cssClass="error" /><br />
		  		<form:hidden path="accountId" />			  		  				  				  			  				  			
		  	</fieldset>
			<p><button type="submit">Submit</button></p>
		</form:form>
	</div>
</body>

