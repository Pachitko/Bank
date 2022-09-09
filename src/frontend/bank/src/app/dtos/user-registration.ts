export class UserRegistration {
    username: string = "";
    email: string = "";
    password: string = "";

    public constructor(init?: Partial<UserRegistration>) {
        Object.assign(this, init);
    }
}
