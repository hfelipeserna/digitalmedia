package digitalmedia.msusers.repository;

import digitalmedia.msusers.models.User;

public interface IUserRepository {
    User findById(String id);
}
