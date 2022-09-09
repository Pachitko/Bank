import { UserAccount } from "./user-account";

export class User {
    username: string = "";
    email: string = "";
    accounts: UserAccount[] = [];
}
