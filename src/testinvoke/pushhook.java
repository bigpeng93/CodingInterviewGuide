package testinvoke;

public class pushhook {
    public String project_name;
    public int project_id;

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    @Override
    public String toString() {
        return "pushhook{" +
                "project_name='" + project_name + '\'' +
                ", project_id='" + project_id + '\'' +
                '}';
    }
}
