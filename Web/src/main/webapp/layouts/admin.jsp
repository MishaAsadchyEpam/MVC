<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <tiles:insertAttribute name="sharedHeader" ignore="true"/>
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
    <tiles:insertAttribute name="header" ignore="true"/>
</head>
<body>
<tiles:insertAttribute name="sharedBody" ignore="true"/>
<tiles:insertAttribute name="body" ignore="true"/>
<tiles:insertAttribute name="sharedFooter" ignore="true"/>
</body>
</html>
