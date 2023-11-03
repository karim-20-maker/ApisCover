package ResponseModels;

public class PetResponse {
    private long id;
    private RequestModel.Pet.Category category;
    private String name;
    private String[] photoUrls;
    private RequestModel.Pet.Tag[] tags;
    private String status;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RequestModel.Pet.Category getCategory() {
        return category;
    }

    public void setCategory(RequestModel.Pet.Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public RequestModel.Pet.Tag[] getTags() {
        return tags;
    }

    public void setTags(RequestModel.Pet.Tag[] tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Category {
        private long id;
        private String name;



        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Tag {
        private long id;
        private String name;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

