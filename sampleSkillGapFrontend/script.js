const careerSelect = document.getElementById("careerSelect");
const skillSelect = document.getElementById("skillSelect");
const analyzeBtn = document.getElementById("analyzeBtn");
const resultDiv = document.getElementById("result");

const BASE_URL = "http://localhost:8080/api/career";

// Load careers on page load
fetch(`${BASE_URL}`)
    .then(res => {
        if (!res.ok) throw new Error("Failed to load careers");
        return res.json();
    })
    .then(data => {
        data.forEach(career => {
            const option = document.createElement("option");
            option.value = career;
            option.textContent = career;
            careerSelect.appendChild(option);
        });
    })
    .catch(() => {
        resultDiv.innerHTML = "<p style='color:red'>Error loading career data</p>";
    });

// When career changes → load skills
careerSelect.addEventListener("change", () => {
    const career = careerSelect.value;
    skillSelect.innerHTML = "<option value=''>Select Skill</option>";
    skillSelect.disabled = true;
    analyzeBtn.disabled = true;

    if (!career) return;

    fetch(`${BASE_URL}/${encodeURIComponent(career)}/skills`)
        .then(res => {
            if (!res.ok) throw new Error("Failed to load skills");
            return res.json();
        })
        .then(skills => {
            skills.forEach(skill => {
                const option = document.createElement("option");
                option.value = skill;
                option.textContent = skill;
                skillSelect.appendChild(option);
            });
            skillSelect.disabled = false;
        })
        .catch(() => {
            resultDiv.innerHTML = "<p style='color:red'>Error loading skills</p>";
        });
});

// Enable analyze button
skillSelect.addEventListener("change", () => {
    analyzeBtn.disabled = !skillSelect.value;
});

// Analyze path
analyzeBtn.addEventListener("click", () => {
    const career = careerSelect.value;
    const skill = skillSelect.value;

    resultDiv.innerHTML = "Loading recommended path...";

    fetch(`${BASE_URL}/path?career=${encodeURIComponent(career)}&skill=${encodeURIComponent(skill)}`)
    .then(res => {
        if (!res.ok) throw new Error("No path found");
        return res.json();
    })
    .then(data => {

        if (!data.frameworks || data.frameworks.length === 0) {
            resultDiv.innerHTML = "<p>No frameworks or courses found</p>";
            return;
        }

        resultDiv.innerHTML = "";

        // Skill heading
        const skillHeading = document.createElement("h2");
        skillHeading.textContent = "Skill: " + data.skill;
        resultDiv.appendChild(skillHeading);

        // Frameworks
        const frameworkTitle = document.createElement("h3");
        frameworkTitle.textContent = "Frameworks";
        resultDiv.appendChild(frameworkTitle);

        data.frameworks.forEach(f => {
            const p = document.createElement("p");
            p.className = "framework";
            p.textContent = "• " + f;
            resultDiv.appendChild(p);
        });

        // Courses
        const courseTitle = document.createElement("h3");
        courseTitle.textContent = "Courses";
        resultDiv.appendChild(courseTitle);

        data.courses.forEach(c => {
            const p = document.createElement("p");
            p.className = "course";
            p.textContent = "• " + c;
            resultDiv.appendChild(p);
        });
    })
    .catch(() => {
        resultDiv.innerHTML = "<p style='color:red'>No framework or course found</p>";
    });

});
