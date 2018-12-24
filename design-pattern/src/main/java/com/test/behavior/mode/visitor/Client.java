package com.test.behavior.mode.visitor;

import com.test.behavior.mode.visitor.element.FulltimeEmployee;
import com.test.behavior.mode.visitor.element.ParttimeEmployee;
import com.test.behavior.mode.visitor.structure.EmployeeList;
import com.test.behavior.mode.visitor.visitor.HRDepartment;

/**
 * Sunny软件公司欲为某银行开发一套OA系统，在该OA系统中包含一个员工信息管理子系统，
 * 该银行员工包括正式员工和临时工，每周人力资源部和财务部等部门需要对员工数据进行汇
 * 总，汇总数据包括员工工作时间、员工工资等。该公司基本制度如下：
 *
 * (1)	正式员工(Full time Employee)每周工作时间为40小时，不同级别、不同部门的员工每周基
 *      本工资不同；如果超过40小时，超出部分按照100元/小时作为加班费；如果少于40小时，所缺
 *      时间按照请假处理，请假所扣工资以80元/小时计算，直到基本工资扣除到零为止。除了记录
 *      实际工作时间外，人力资源部需记录加班时长或请假时长，作为员工平时表现的一项依据。
 *
 * (2)	临时工(Part time Employee)每周工作时间不固定，基本工资按小时计算，不同岗位的临时
 *      工小时工资不同。人力资源部只需记录实际工作时间。
 *      人力资源部和财务部工作人员可以根据各自的需要对员工数据进行汇总处理，人力资源部负
 *      责汇总每周员工工作时间，而财务部负责计算每周员工工资。


 * FADepartment表示财务部，HRDepartment表示人力资源部，它们充当具体访问者
 * 角色，其抽象父类Department充当抽象访问者角色；EmployeeList充当对象结构，用于存储员
 * 工列表；FulltimeEmployee表示正式员工，ParttimeEmployee表示临时工，它们充当具体元素角
 * 色，其父接口Employee充当抽象元素角色
 */
public class Client {
    public static void main(String[] args) {
        EmployeeList employeeList = new EmployeeList();
        FulltimeEmployee fulltimeEmployee1 = new FulltimeEmployee("张三", 3200, 45);
        FulltimeEmployee fulltimeEmployee2 = new FulltimeEmployee("李四", 4200, 40);
        FulltimeEmployee fulltimeEmployee3 = new FulltimeEmployee("王五", 2200, 35);
        ParttimeEmployee parttimeEmployee1 = new ParttimeEmployee("赵六", 2200, 30);
        ParttimeEmployee parttimeEmployee2 = new ParttimeEmployee("孙李", 2200, 45);

        employeeList.addEmployee(fulltimeEmployee1);
        employeeList.addEmployee(fulltimeEmployee2);
        employeeList.addEmployee(fulltimeEmployee3);
        employeeList.addEmployee(parttimeEmployee1);
        employeeList.addEmployee(parttimeEmployee2);

        HRDepartment hrDepartment = new HRDepartment();
        employeeList.handle(hrDepartment);

    }
}
