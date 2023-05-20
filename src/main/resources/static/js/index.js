
const content = document.querySelector('.content');
const templateProject = content.querySelector("#projects-add");
const projectsColumn = content.querySelector('.projects');
const headers = {
                 'Content-Type': 'application/json'
}

function fillProjects() {
  const api = new Api('http://localhost:8189', headers);
  api.getProjects().then((projects) => {
      projects.forEach((project) => {
             let buttonProject = document.createElement('button');
             buttonProject.setAttribute('class','projects__project');
             buttonProject.setAttribute('type','button');
             buttonProject.textContent = project.name;
             projectsColumn.appendChild(buttonProject);
      });
  })
}

fillProjects();

