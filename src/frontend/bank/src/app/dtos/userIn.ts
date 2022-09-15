import { UserAccountIn } from './user-account-in';

export class UserIn {
  username: string | undefined;
  email: string | undefined;
  accounts: UserAccountIn[] = [];
}
