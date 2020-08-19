<#import "partials/header.ftlh" as main />

<@main.renderWith scripts=["https://code.jquery.com/jquery-3.3.1.slim.min.js","https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js","https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"] styles=["https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"]>

    <div class="mx-auto mt-3 w-50">

        <h3>Statistic</h3>
        <br>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">User</th>
                <th scope="col">All Points</th>
            </tr>
            </thead>
            <tbody id="Table">
            <#list games as game>
                <tr>
                    <th scope="row">${game?counter}</th>
                    <td>${game.name!"-null-"}</td>
                    <td>${game.point!"-null-"}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>

</@main.renderWith>