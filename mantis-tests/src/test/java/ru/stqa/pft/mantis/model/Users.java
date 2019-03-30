package ru.stqa.pft.mantis.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Users extends ForwardingSet<UserData> {
    private Set<UserData> delegate;

    public Users(Users Users) {
        this.delegate = new HashSet<>(Users.delegate);
    }

    public Users() {
        this.delegate = new HashSet<>();
    }

    public Users(Collection<UserData> Users) {
        this.delegate = new HashSet<>(Users);
    }

    @Override
    protected Set<UserData> delegate() {
        return delegate;
    }

}
