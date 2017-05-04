<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Add student</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.student.id" />
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="ufname">First Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.student.name" id="unfame" class="studentname form-control input-sm" placeholder="Enter first name" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="ulname">Last Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.age" id="ulname" class="form-control input-sm" placeholder="Enter last name." required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="group">Group</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.salary" id="group" class="form-control input-sm" placeholder="Enter group." required ng-pattern="ctrl.onlyIntegers"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Users </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>FIRST NAME</th>
                        <th>LAST NAME</th>
                        <th>GROUP</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="u in ctrl.getAllStudents()">
                        <td>{{u.id}}</td>
                        <td>{{u.firstName}}</td>
                        <td>{{u.lastName}}</td>
                        <td>{{u.idGroup}}</td>
                        <td><button type="button" ng-click="ctrl.editStudent(u.id)" class="btn btn-success custom-width">Edit</button></td>
                        <td><button type="button" ng-click="ctrl.removeStudent(u.id)" class="btn btn-danger custom-width">Remove</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>