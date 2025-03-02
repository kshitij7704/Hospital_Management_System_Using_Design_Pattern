public abstract class UserDecorator extends User {
    protected User decoratedUser;

    public UserDecorator(User user) {
        super(user.getName(), user.getUsername(), user.getPassword(), user.getRole());
        this.decoratedUser = user;
    }

    @Override
    public String getRole() {
        return decoratedUser.getRole();
    }

    @Override
    public String toString() {
        return decoratedUser.toString();
    }
}