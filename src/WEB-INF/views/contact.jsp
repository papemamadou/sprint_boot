<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Liste des contacts</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<header>
    <h1>Gestion de contacts</h1>
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/contact" >Accueil</a></li>
            <li><a href="${pageContext.request.contextPath}/contacts/ajouter">Ajouter Contact</a></li>
            <li><a href="${pageContext.request.contextPath}/contacts/lister" class="active">Liste des Contacts</a></li>
            <li><a href="${pageContext.request.contextPath}/groupes/lister">Groupes</a></li>
            <li><a href="${pageContext.request.contextPath}/importer">Importer</a></li>
        </ul>
    </nav>
</header>

<main>
    <h2>Liste des contacts</h2>

    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Email</th>
            <th>Téléphone</th>
            <th>Priorité</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="contact" items="${contacts}">
            <tr>
                <td><c:out value="${contact.id}" /></td>
                <td><c:out value="${contact.nom}" /></td>
                <td><c:out value="${contact.prenom}" /></td>
                <td><c:out value="${contact.email}" /></td>
                <td><c:out value="${contact.telephone}" /></td>
                <td><c:out value="${contact.priorite}" /></td>
                <td>
                    <a href="${pageContext.request.contextPath}/contacts/modifier?id=${contact.id}">Modifier</a> |
                    <a href="${pageContext.request.contextPath}/contacts/supprimer?id=${contact.id}" onclick="return confirm('Confirmer la suppression ?');">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty contacts}">
            <tr>
                <td colspan="7">Aucun contact trouvé.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</main>

</body>
</html>
