package top.shahow.service;

public interface IUserService<T> {
	public T login(T user);
	public boolean register(T user);
	public boolean validName(String name);
}
