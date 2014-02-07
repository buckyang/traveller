<head>
	<title>新建拼团</title>
</head>
<body>
	<div id="formsContent">
		<h2>新建拼团</h2>
		<form:form id="form" method="post" modelAttribute="travelGroupDTO">
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
		  		<legend>拼团</legend>
		  		<form:label path="fromResort">出发景点</form:label>
		  		<form:input path="fromResort" /><form:errors path="fromResort" cssClass="error" /><br />
		  		<form:label path="fromCity">出发城市</form:label>
		  		<form:input path="fromCity" /><form:errors path="fromCity" cssClass="error" /><br />		  			
		  		<form:label path="fromAddress">出发地址</form:label>
		  		<form:input path="fromAddress" /><form:errors path="fromAddress" cssClass="error" /><br />
		  		<form:label path="arrivalCity">目的地城市</form:label>
		  		<form:input path="arrivalCity" /><form:errors path="arrivalCity" cssClass="error" /><br />
		  		<form:label path="arrivalResort">目的地景点</form:label>
		  		<form:input path="arrivalResort" /><form:errors path="arrivalResort" cssClass="error" /><br />
		  		<form:label path="fromDate">出发日期</form:label>
		  		<form:input path="fromDate" /><form:errors path="fromDate" cssClass="error" /><br />
		  		<form:label path="type">自助游类型</form:label>
		  		<form:select path="type">
					<form:options items="${travelTypeDTOList}" itemValue="typeName" itemLabel="typeName"/>		  			
		  		</form:select>
		  		<br />		  		
		  		<form:label path="days">预计天数</form:label>
		  		<form:input path="days" /><form:errors path="days" cssClass="error" /><br />
		  		<form:label path="count">最低参团人数</form:label>
		  		<form:input path="count" /><form:errors path="count" cssClass="error" /><br />		  		
		  		<form:label path="budget">预计花费</form:label>
		  		<form:input path="budget" /><form:errors path="budget" cssClass="error" /><br />
		  		<form:label path="topic">拼团主题</form:label>
		  		<form:input path="topic" /><form:errors path="topic" cssClass="error" /><br />		  		
		  		<form:label path="note">备注</form:label>
		  		<form:input path="note" /><form:errors path="note" cssClass="error" /><br />
		  		<form:hidden path="initiator" />		  				  				  				  				  		
		  	</fieldset>
		  	<fieldset>
		  		<legend>行程表</legend>
		  		<form:label path="scheduleNoteDTOs[0].dayNumber">天数&nbsp;&nbsp;1</form:label>
		  		<form:hidden path="scheduleNoteDTOs[0].dayNumber" value="1"/><br />		  		
		  		<form:label path="scheduleNoteDTOs[0].note">行程计划</form:label>
		  		<form:input path="scheduleNoteDTOs[0].note" /><form:errors path="scheduleNoteDTOs[0].note" cssClass="error" /><br />		
		  		<form:label path="scheduleNoteDTOs[1].dayNumber">天数&nbsp;&nbsp;2</form:label>
		  		<form:hidden path="scheduleNoteDTOs[1].dayNumber" value="2"/><br />		  		
		  		<form:label path="scheduleNoteDTOs[1].note">行程计划</form:label>
		  		<form:input path="scheduleNoteDTOs[1].note" /><form:errors path="scheduleNoteDTOs[1].note" cssClass="error" /><br />				  		  			
		  	</fieldset>
			<p><button type="submit">Submit</button></p>
		</form:form>
	</div>
</body>

