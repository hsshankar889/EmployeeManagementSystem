function addEmployee()
{
let ae=document.getElementById("add_employee");
ae.style.display="block";
let ue=document.getElementById("update_employee");
ue.style.display="none";
let dae=document.getElementById("deleteAllEmployee");
dae.style.display="none";
let de=document.getElementById("deleteEmployee");
de.style.display="none";
let uf=document.getElementById("updateEmployeeForm");
uf.style.display="none";
}

function updateEmployee()
{
let ue=document.getElementById("update_employee");
ue.style.display="none";
let ae=document.getElementById("add_employee");
ae.style.display="none";
let de=document.getElementById("deleteEmployee");
de.style.display="none";
let dae=document.getElementById("deleteAllEmployee");
dae.style.display="none";
let uf=document.getElementById("updateEmployeeForm");
uf.style.display="block";
}


function deleteEmployee()
{
let de=document.getElementById("deleteEmployee");
de.style.display="block";
let ae=document.getElementById("add_employee");
ae.style.display="none";
let ue=document.getElementById("update_employee");
ue.style.display="none";
let dae=document.getElementById("deleteAllEmployee");
dae.style.display="none";
let uf=document.getElementById("updateEmployeeForm");
uf.style.display="none";
}

function deleteAllEmployee()
{
let dae=document.getElementById("deleteAllEmployee");
dae.style.display="block";
let de=document.getElementById("deleteEmployee");
de.style.display="none";
let ae=document.getElementById("add_employee");
ae.style.display="none";
let ue=document.getElementById("update_employee");
ue.style.display="none";
let uf=document.getElementById("updateEmployeeForm");
uf.style.display="none";

}

 function cancel()
 {
 let dae=document.getElementById("deleteAllEmployee");
dae.style.display="none";
let de=document.getElementById("deleteEmployee");
de.style.display="none";
let ae=document.getElementById("add_employee");
ae.style.display="none";
let ue=document.getElementById("update_employee");
ue.style.display="none";
let uf=document.getElementById("updateEmployeeForm");
uf.style.display="none";
 
 }