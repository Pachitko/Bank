export interface UserResponse<T>
{
    value: T;
    exception: string;
    succeeded: boolean;
}

export interface UserResponseError{
    name: string;
    description: string;
}