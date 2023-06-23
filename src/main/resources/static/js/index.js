
const content = document.querySelector('.content');
const templateProject = content.querySelector("#projects-add");
const projectSection = content.querySelector('.projects');
const subprojectSection = content.querySelector('.subprojects');

const headers = {
                 'Content-Type': 'application/json'
}

const api = new Api('http://localhost:8189', headers);

function clearElements(parent) {
    while(parent.firstChild) {
        parent.removeChild(parent.firstChild);
    }
    console.log('я все очистила ' + parent);
}


function fillTasks(evt) {
    console.log("fillTasks");
}

function fillSubproject(evt) {
//    alert('id this button' + evt.target.id);
    clearElements(subprojectSection);//очищаем секцию подпроектов
    api.getSubprojects(evt.target.id).then((project) => {
        project.subprojects.forEach((subproject) => {
            const buttonSubproject = new Button(subproject.id,
                                                subproject.name,
                                                'subprojects__subproject',
                                                fillTasks).
            generateButton();
            buttonSubproject.addEventListener('click', fillTasks);
            subprojectSection.appendChild(buttonSubproject);
        });
    })
}

function fillProjects() {
  console.log(subprojectSection);
  clearElements(subprojectSection);//очищаем секцию подпроектов
  api.getProjects().then((projects) => {
      projects.forEach((project) => {
         const buttonProject = new Button(project.id,
                                          project.name,
                                          'projects__project',
                                          fillSubproject).
         generateButton();
         buttonProject.addEventListener('click', fillSubproject);
         projectSection.appendChild(buttonProject);
      });

  })
}

fillProjects();

